# AndroidJUnitParams
Android extension to JUnitParams providing an enhanced runner that honors annotations such as UiThreadTest

| Latest version                                                                                                                                                                                                                             |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ ![Download](https://maven-badges.herokuapp.com/maven-central/com.forkingcode.androidjunitparams/androidjunitparams/badge.svg?subject=androidjunitparams) ](https://maven-badges.herokuapp.com/maven-central/com.forkingcode.androidjunitparams/androidjunitparams) |

Usage
-----

1. Add AndroidJUnitParamsRunner to be the runner for you test

```java
@RunWith(AndroidJUnitParamsRunner.class)
public class ExampleInstrumentedTest {
```

2. Annotate your test with @Parameters and @UiThreadTest as needed

```java
    @Test
    @Parameters(method = "evens")
    @UiThreadTest
    public void testEvens(int value) {
```

3. Run tests at the class level. This allows the parameterized tests to run correctly as essentially the there are multiple tests per individual test.

License
-------

    Copyright (C) 2017 Joe Rogers

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
