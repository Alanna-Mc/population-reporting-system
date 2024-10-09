# This Dockerfile is for setting up a MySQL container

# Official MySQL image version 8.3
FROM mysql:8.3

# Set the working directory inside the container to /tmp
WORKDIR /tmp

# Copy all SQL database files from the build context to the working directory
COPY *.sql /tmp/

# Copy the main SQL file to docker-entrypoint-initdb.d.
# Scripts and SQL files in this folder are executed on container startup.
# This is specific to MySQL.
COPY world.sql /docker-entrypoint-initdb.d

# Set the root password for MySQL
ENV MYSQL_ROOT_PASSWORD my-secret-pw