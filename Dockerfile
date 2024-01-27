FROM container-registry.oracle.com/os/oraclelinux:9-slim
WORKDIR /app
ARG APP_FILE
EXPOSE 8080
COPY ${APP_FILE} /app/demo-app
ENTRYPOINT ["/app/demo-app"]