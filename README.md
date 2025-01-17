# TimeHubJava

In this project the goal is to create a time tracking tool with some extra features like a ticket system, todo-list, 
event-system and export functions. The project has the 'Java' extension in his name, because the first idea was to 
create this project with C++. Maybe the C++ version will continued in the feature.

## Version

### 0.1

## Developing

This section is about all important things about the developing process in this project. Things like the formatting are 
part of this section and how this should be set up.

### Formatting

There are already good guidelines for some aspects of programming, including formatting in the individual programming 
languages. In Java, naming is carried out on the basis of the camel case notation. Other things like where the start and
ending curly bracket of method should be placed (same row as the declaration or in the following row) is not clear 
sometimes. To avoid different code styling like this the 'Java Google Style' is used. There are different ways to use 
such a styling file in the ide`s. In the official GitHub repo 
(https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml) you are able to download it from 
there and use it. In some IDEs like IntelliJ (in my case) there are also plugins available to handle this. In the 
following will be describe how to set up this for IntelliJ easily. <br>

1. Go to Menu -> Settings -> Plugin -> Marketplace
2. Search for 'google-java-format'
3. Install it and close the window (another restart is required later)
4. Go to Menu -> Help -> Edit Custom VM Options...
5. Add the following to the opened file:
```text
--add-exports=jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
--add-exports=jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
```
6. Restart the IDE
7. Go to Menu -> Settings -> google-java-format Settings
8. Enable the google-java-format and select 'Default Google Java Style' as format