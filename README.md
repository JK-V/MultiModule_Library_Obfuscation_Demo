# MultiModule_Library_Obfuscation_Demo
This repo will describe the obfuscation challenges and solutions that an Android Multi Modular library application does have.
In this repo you will find we are preparing the final deliverable sdk library from 3 layer multi modular dependencies.
1. Core : Only contains the core bisness rules[By theory], but right now only coreInterface.
2. Middleware : That hides the processing complexity of making netowrk call and mapping data in DTOs[by theory] but right now only implements coreInterface and does have public contract.
3. fcade : The abstract exposing module which hides ll granular level of details and exposes simple APIs to the client[by theory], right now exposes SDKManager which allows access to underlying APIs.

The dependecy grapgh between above escribed modules looks like:
    facade -> middleware -> core

We've proguard enalbed in all the packages, which will run when we hit rebuild project in release mode.

If we obfuscate all the packages the ideal scenario would be:
1. Ideal Scenario: The expectation here it should build transitive depenecies. 
      According dependecy graph obfuscation should first build core and then go for middleware after building middleware the proguard should run obfuscation on facade, and the resulting aar will contain facade with exposed public APIs along with the dependent classes from sub modules.

2. Actual Scenario: Try building the project you will be disappointed with the result. What we've calculated and what has been prepared have a lot of discripacies. 

If you've prepared the build of project, you must be aware about the issue, now the solution part comes into picture:
1. If you build the project, proguard will remove the classes from dependent modules[middleware, core] as they are not exposed as public, and nobody is using them right now in the module. We were expecting gradle to build it along with the accessing module[i.e. facade] and preserve the classes used in above module layers referred from dependent modules.
But as gradle don't build transitive dependencies. You will find that your code from dependent moules have been completely wiped out by proguard. So now to solve this, You make the exposing classes public in all the modules including core and middleware.

Now you are expecting that after supplying this to the mighty gradle, it will build this for you. But... you were wrong!!
One improvement that you can see is the aars from all modules now have at least some code rather than being empty.
But this haven't solved your problem, still you can't see all code connected in facade.

Solution:
          The dependent modules should only contain pure Java code and you can generate the jars out of it even after obfuscating and these prepared jars can be part of top layer i.e. facade's libs folder. So while building aar of facade the code middeware would be accessible as expected and middleware will have core jar file in it's libs folder, so middleware can access it's classes.

Conclusion:
            In android it souds good to follow multi modular project heirarchy to keep layers swipable and make it look more aligned to design principles but as Gradle will not build transitive denepencies, this approach won't work until you follow the solution.
            
