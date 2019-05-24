# nasa-rover

## Build the project

1) Build the project with: 
`./gradlew build`

2) Perform a dummy execution:
`./gradlew run`

3) Launch the test coverage report:
`./gradlew jacocoTestReport`

4) Check the report:
`firefox build/reports/jacoco/test/html/index.html`

## Assumptions

1) A Rover with an invalid initial position will be not included in the final deployment
2) In a collision or out of bounds scene, the active Rover will go forward until the last available position and he will stop there
