## System Requirements
- Maven 3.6.0+
- JDK 8+
- Firefox, Chrome browsers installed

## Setup

1. Optionally, add these properties with your values to `src/main/resources/app.properties`:
    - `QASE_ENABLE=true`
    - `QASE_PROJECT_CODE=PRJ`
    - `QASE_RUN_ID=123`
    - `QASE_API_TOKEN=secret-token`
    - `BROWSER_HEADLESS=true`
    - Set custom binary path or leave empty for automatic detection:
        - `BROWSER_CHROME_BINARY_PATH=/path/to/binary`
        - `BROWSER_FIREFOX_BINARY_PATH=/path/to/binary`
2. If there is a snap version of Firefox in the system, you must set `TMPDIR` environment variable:
    - `mkdir -p $HOME/snap/firefox/common/tmp`
    - `export TMPDIR="$HOME/snap/firefox/common/tmp"`

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