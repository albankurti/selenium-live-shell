@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  SeleniumLiveShell startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and SELENIUM_LIVE_SHELL_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\SeleniumLiveShell-0.0.1-SNAPSHOT.jar;%APP_HOME%\lib\selenium-java-4.1.2.jar;%APP_HOME%\lib\selenium-chrome-driver-4.1.2.jar;%APP_HOME%\lib\junit-4.13.2.jar;%APP_HOME%\lib\poi-ooxml-5.0.0.jar;%APP_HOME%\lib\poi-5.0.0.jar;%APP_HOME%\lib\extentreports-2.41.2.jar;%APP_HOME%\lib\batik-all-1.13.jar;%APP_HOME%\lib\batik-rasterizer-ext-1.13.jar;%APP_HOME%\lib\batik-rasterizer-1.13.jar;%APP_HOME%\lib\batik-svgrasterizer-1.13.jar;%APP_HOME%\lib\batik-codec-1.13.jar;%APP_HOME%\lib\batik-squiggle-ext-1.13.jar;%APP_HOME%\lib\batik-extension-1.13.jar;%APP_HOME%\lib\batik-slideshow-1.13.jar;%APP_HOME%\lib\batik-squiggle-1.13.jar;%APP_HOME%\lib\batik-svgbrowser-1.13.jar;%APP_HOME%\lib\batik-swing-1.13.jar;%APP_HOME%\lib\batik-svgpp-1.13.jar;%APP_HOME%\lib\batik-transcoder-1.13.jar;%APP_HOME%\lib\batik-bridge-1.13.jar;%APP_HOME%\lib\batik-script-1.13.jar;%APP_HOME%\lib\batik-anim-1.13.jar;%APP_HOME%\lib\batik-gvt-1.13.jar;%APP_HOME%\lib\batik-svg-dom-1.13.jar;%APP_HOME%\lib\batik-parser-1.13.jar;%APP_HOME%\lib\batik-ttf2svg-1.13.jar;%APP_HOME%\lib\batik-svggen-1.13.jar;%APP_HOME%\lib\batik-awt-util-1.13.jar;%APP_HOME%\lib\batik-dom-1.13.jar;%APP_HOME%\lib\batik-css-1.13.jar;%APP_HOME%\lib\xmlgraphics-commons-2.4.jar;%APP_HOME%\lib\commons-io-20030203.000550.jar;%APP_HOME%\lib\testng-7.5.jar;%APP_HOME%\lib\selenium-firefox-xpi-driver-4.1.2.jar;%APP_HOME%\lib\selenium-firefox-driver-4.1.2.jar;%APP_HOME%\lib\selenium-devtools-v85-4.1.2.jar;%APP_HOME%\lib\selenium-devtools-v95-4.1.2.jar;%APP_HOME%\lib\selenium-devtools-v96-4.1.2.jar;%APP_HOME%\lib\selenium-devtools-v97-4.1.2.jar;%APP_HOME%\lib\selenium-edge-driver-4.1.2.jar;%APP_HOME%\lib\selenium-ie-driver-4.1.2.jar;%APP_HOME%\lib\selenium-opera-driver-4.1.2.jar;%APP_HOME%\lib\selenium-safari-driver-4.1.2.jar;%APP_HOME%\lib\selenium-support-4.1.2.jar;%APP_HOME%\lib\selenium-chromium-driver-4.1.2.jar;%APP_HOME%\lib\selenium-remote-driver-4.1.2.jar;%APP_HOME%\lib\selenium-http-4.1.2.jar;%APP_HOME%\lib\selenium-json-4.1.2.jar;%APP_HOME%\lib\selenium-api-4.1.2.jar;%APP_HOME%\lib\auto-service-1.0.1.jar;%APP_HOME%\lib\auto-service-annotations-1.0.1.jar;%APP_HOME%\lib\auto-common-1.2.jar;%APP_HOME%\lib\guava-31.0.1-jre.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.30.jar;%APP_HOME%\lib\xmlsec-2.2.1.jar;%APP_HOME%\lib\async-http-client-2.12.3.jar;%APP_HOME%\lib\async-http-client-netty-utils-2.12.3.jar;%APP_HOME%\lib\slf4j-api-1.7.32.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-math3-3.6.1.jar;%APP_HOME%\lib\SparseBitSet-1.2.jar;%APP_HOME%\lib\poi-ooxml-lite-5.0.0.jar;%APP_HOME%\lib\commons-compress-1.20.jar;%APP_HOME%\lib\curvesapi-1.06.jar;%APP_HOME%\lib\bcpkix-jdk15on-1.68.jar;%APP_HOME%\lib\bcprov-jdk15on-1.68.jar;%APP_HOME%\lib\graphics2d-0.30.jar;%APP_HOME%\lib\jsoup-1.8.3.jar;%APP_HOME%\lib\sqlite-jdbc-3.8.11.1.jar;%APP_HOME%\lib\freemarker-2.3.23.jar;%APP_HOME%\lib\mongodb-driver-3.0.4.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\jcommander-1.82.jar;%APP_HOME%\lib\jquery-3.5.1.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.60.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.73.Final-linux-x86_64.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-kqueue-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-kqueue-4.1.73.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-transport-classes-kqueue-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.73.Final.jar;%APP_HOME%\lib\netty-reactive-streams-2.0.4.jar;%APP_HOME%\lib\netty-handler-4.1.73.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.60.Final.jar;%APP_HOME%\lib\netty-codec-4.1.73.Final.jar;%APP_HOME%\lib\netty-transport-4.1.73.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.73.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.73.Final.jar;%APP_HOME%\lib\netty-common-4.1.73.Final.jar;%APP_HOME%\lib\opentelemetry-exporter-logging-1.10.1.jar;%APP_HOME%\lib\opentelemetry-sdk-extension-autoconfigure-1.10.1-alpha.jar;%APP_HOME%\lib\opentelemetry-sdk-extension-autoconfigure-spi-1.10.1.jar;%APP_HOME%\lib\opentelemetry-sdk-1.10.1.jar;%APP_HOME%\lib\opentelemetry-sdk-trace-1.10.1.jar;%APP_HOME%\lib\opentelemetry-sdk-metrics-1.10.1-alpha.jar;%APP_HOME%\lib\opentelemetry-sdk-logs-1.10.1-alpha.jar;%APP_HOME%\lib\opentelemetry-sdk-common-1.10.1.jar;%APP_HOME%\lib\opentelemetry-semconv-1.10.1-alpha.jar;%APP_HOME%\lib\opentelemetry-api-1.10.1.jar;%APP_HOME%\lib\opentelemetry-context-1.10.1.jar;%APP_HOME%\lib\jtoml-2.0.0.jar;%APP_HOME%\lib\byte-buddy-1.12.7.jar;%APP_HOME%\lib\commons-exec-1.3.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\checker-qual-3.12.0.jar;%APP_HOME%\lib\error_prone_annotations-2.7.1.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\xmlbeans-4.0.0.jar;%APP_HOME%\lib\woodstox-core-5.2.1.jar;%APP_HOME%\lib\batik-gui-util-1.13.jar;%APP_HOME%\lib\batik-xml-1.13.jar;%APP_HOME%\lib\batik-util-1.13.jar;%APP_HOME%\lib\batik-constants-1.13.jar;%APP_HOME%\lib\batik-ext-1.13.jar;%APP_HOME%\lib\batik-i18n-1.13.jar;%APP_HOME%\lib\pdfbox-2.0.22.jar;%APP_HOME%\lib\mongodb-driver-core-3.0.4.jar;%APP_HOME%\lib\bson-3.0.4.jar;%APP_HOME%\lib\reactive-streams-1.0.3.jar;%APP_HOME%\lib\jakarta.activation-1.2.2.jar;%APP_HOME%\lib\failsafe-2.4.4.jar;%APP_HOME%\lib\stax2-api-4.2.jar;%APP_HOME%\lib\batik-shared-resources-1.13.jar;%APP_HOME%\lib\xml-apis-ext-1.3.04.jar;%APP_HOME%\lib\xalan-2.7.2.jar;%APP_HOME%\lib\serializer-2.7.2.jar;%APP_HOME%\lib\xml-apis-1.4.01.jar;%APP_HOME%\lib\fontbox-2.0.22.jar;%APP_HOME%\lib\netty-tcnative-classes-2.0.46.Final.jar


@rem Execute SeleniumLiveShell
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SELENIUM_LIVE_SHELL_OPTS%  -classpath "%CLASSPATH%" com.invicto.LiveShell %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable SELENIUM_LIVE_SHELL_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%SELENIUM_LIVE_SHELL_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
