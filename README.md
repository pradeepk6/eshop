#####requirements to run:
* java 1.8 and maven 3.3.9

#####tested on:
* maven based project developed using IntelliJ
* os : windows 10
* firefox(53.0.2 64bit) and gecko driver-version: 0.16.1
* edge(14.14393) and driver-version: 3.14393
* chrome(58.0.3029.96 64-bit) and driver-version: 2.29
* phantomjs and htmlunit; both throwing errors

#####how to run:
* mvn verify
* The above command tests with the default browser choice : chrome
system-property 'browser' can be changed to firefox or edge in the pom file
or passed via maven for eg: mvn verify -Dbrowser="firefox"

#####driver binaries download plugin:
The project uses a plugin 'driver-binary-downloader-maven-plugin'
to download specified binaries for the current OS and bit version
to the directory src/test/drivers and sets the system property
webdriver.<browserName>.driver.See the plugin in the
pom file to see what drivers and versions specified.
If the plugin fails to download at all or the specified binary then
driver binaries have to be downloaded manually and the 'system property'
has to be passed in via maven.For eg: 
mvn verify -Dbrowser="chrome" -Dwebdriver.chrome.driver="file location of standalone driver exe file"



