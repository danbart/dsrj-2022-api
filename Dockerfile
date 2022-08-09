FROM payara/micro:5.2022.2

COPY ./jars/mysql-connector-java-5.1.23-bin.jar /opt/payara/database-connector.jar

COPY ./target/dsrj-api.war $DEPLOY_DIR

ENTRYPOINT ["--addLibs","/opt/payara/config/mysql-connector-java-5.1.23-bin.jar"]
ENTRYPOINT [  "java", "-jar", "/opt/payara/payara-micro.jar","--nocluster","--logo", "--deploy","/opt/payara/deployments/dsrj-api.war"]

EXPOSE 8080