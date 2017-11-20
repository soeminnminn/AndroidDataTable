# Datatable

[![Maven Central][mavenbadge-svg]][mavenbadge]

## Installation

You will need to include the `datatable-1.0.x.jar` in your application's runtime.

### Maven

In a Maven project, include the `datatable` artifact in the dependencies section of your `pom.xml`:

``` xml
<dependency> 
  <groupId>com.s16</groupId>
  <artifactId>datatable</artifactId>
  <version>1.0.0.0</version>
  <type>pom</type>
</dependency>
```

### Java Gradle

```groovy
// Add plugin https://plugins.gradle.org/plugin/net.ltgt.apt
plugins {
  id "net.ltgt.apt" version "0.10"
}

// Add Datatable dependencies
dependencies {
  compile 'com.s16:datatable:1.0.0.0'
}
```

### Android Gradle
```groovy
// Add Datatable dependencies
dependencies {
  compile 'com.s16:datatable:1.0.0.0'
}
```

## License

    Copyright 2017 The Datatable Authors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.