# Guru99 Automation Framework

This project automates the Guru99 banking demo site using Selenium WebDriver, Java, and TestNG.

## Prerequisites

- **Java JDK 11 or higher** (You have Java 23 installed)
- **Maven**: Necessary for dependency management and running tests.

### Installing Maven on Windows

1. Download Maven: [Apache Maven Download](https://maven.apache.org/download.cgi) (Binary zip archive).
2. Extract the archive to a directory, e.g., `C:\Program Files\Apache\maven`.
3. Add `bin` directory to Path:
    - Search for "Edit the system environment variables".
    - Click "Environment Variables".
    - Under "System variables", find `Path` and click "Edit".
    - Click "New" and add the path to the `bin` folder (e.g., `C:\Program Files\Apache\maven\bin`).
    - Click OK.
4. Verify installation by running `mvn -version` in a new command prompt.

## Configuration

Update `src/main/resources/config.properties` if needed:

```properties
url=https://demo.guru99.com/V4/
username=mngr545347  <-- Replace with your valid credentials if expired
password=qAbUruz     <-- Replace with your valid credentials if expired
browser=chrome
```

## Running Tests

Once Maven is installed, navigate to the project root and run:

```sh
mvn test
```

This will run all tests specified in `testng.xml` and generate a report despite any test failures.

## Reporting

After execution, the ExtentReport will be available at:
`target/extent-reports/extent-report.html`
