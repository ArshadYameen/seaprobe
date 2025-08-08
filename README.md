How to run:
- Requires Java 17+
- Start the server: ./gradlew bootRun
- Endpoints:
  - POST /probe/init    (e.g., {"x":0,"y":0,"direction":"UP"})
  - POST /probe/command (e.g., {"commands":["F","R","F"]})
  - GET  /probe/status

Tests & coverage:
- Run: ./gradlew clean test jacocoTestReport
- Coverage report: build/reports/jacoco/test/html/index.html (although not covered 100% due to 3-4 hour time constraint)

Notes/Assumptions:
- Grid: 10x10 by default, no obstacles set via API in this version
- Edge cases handled: bounds, obstacles (in domain), invalid commands/direction, uninitialized probe
