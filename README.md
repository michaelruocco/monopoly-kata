# Monopoly Kata

[![Build](https://github.com/michaelruocco/monopoly-kata/workflows/pipeline/badge.svg)](https://github.com/michaelruocco/monopoly-kata/actions)
[![codecov](https://codecov.io/gh/michaelruocco/monopoly-kata/branch/master/graph/badge.svg?token=FWDNP534O7)](https://codecov.io/gh/michaelruocco/monopoly-kata)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/272889cf707b4dcb90bf451392530794)](https://www.codacy.com/gh/michaelruocco/monopoly-kata/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/monopoly-kata&amp;utm_campaign=Badge_Grade)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/monopoly-kata?branch=master)](https://bettercodehub.com/)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_monopoly-kata&metric=alert_status)](https://sonarcloud.io/dashboard?id=michaelruocco_monopoly-kata)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_monopoly-kata&metric=sqale_index)](https://sonarcloud.io/dashboard?id=michaelruocco_monopoly-kata)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_monopoly-kata&metric=coverage)](https://sonarcloud.io/dashboard?id=michaelruocco_monopoly-kata)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_monopoly-kata&metric=ncloc)](https://sonarcloud.io/dashboard?id=michaelruocco_monopoly-kata)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This project is my attempt at the monopoly kata exercise that is outlined
[here](https://schuchert.github.io/wikispaces/pages/Monopoly)

I have chosen to use cucumber as my BDD tool to translate the stated acceptance criteria into an executable
specification to help verify the correctness of the system. The implementation has been developed using TDD, and I have
tried to keep the code as clean and simple as possible. Feedback and comments are very welcome!

## Test Reports

Cucumber test reports from pipeline runs can be viewed [here](https://reports.cucumber.io/reports/52e8d833-95f1-4585-917c-96429cfc0d30)

## Useful Commands

```gradle
// cleans build directories
// prints currentVersion
// formats code
// builds code
// runs tests
// runs cucumber integration tests
// checks for gradle issues
// checks dependency versions
./gradlew clean currentVersion dependencyUpdates lintGradle spotlessApply build cucumber
```