FROM openjdk:8-jre-alpine

# Copy war file
COPY test-0.0.1-SNAPSHOT.war /test.war

# run the app
CMD ["/usr/bin/java", "-jar", "/test.war"]