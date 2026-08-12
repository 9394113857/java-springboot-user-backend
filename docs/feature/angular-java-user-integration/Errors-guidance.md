<!--  -->
.\mvnw.cmd test 2>&1 | Select-String -Pattern "Caused by:|Exception:|Error:" -Context 0,5

.\mvnw.cmd test

.\mvnw.cmd test





