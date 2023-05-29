## Installation
```
  mvn clean install
```
## Set app properties
Add these properties with your values to `src/test/java/com/common/app.properties`:
`QASE_ENABLE=true`
`QASE_PROJECT_CODE=PRJ`
`QASE_RUN_ID=123`
`QASE_API_TOKEN=secret-token`

## Running Tests
#### With Qase
```bash
  mvn clean test -Pqase-test
```
or
```bash
  mvn clean test -DQASE_ENABLE=true -DQASE_PROJECT_CODE=PRJ -DQASE_RUN_ID=123 -DQASE_API_TOKEN=secret-token
```
#### Without Qase
```bash
  mvn clean test
```

