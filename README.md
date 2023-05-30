## Minimum Requirements
- Maven 3.6.3
- Java 11.0.18
- Linux / macOS
- Firefox, Chrome browsers installed

## Setup

1. Add these properties with your values to `src/test/java/com/common/app.properties`:
    - `QASE_ENABLE=true`
    - `QASE_PROJECT_CODE=PRJ`
    - `QASE_RUN_ID=123`
    - `QASE_API_TOKEN=secret-token`
2. If there is a snap version of Firefox in the system, you must set `TMPDIR` environment variable:
    - `mkdir -p $HOME/snap/firefox/common/tmp`
    - `export TMPDIR="$HOME/snap/firefox/common/tmp"`
    - Restart code editor

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