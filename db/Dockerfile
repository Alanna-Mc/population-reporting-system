# Use MySQL version 8.3
FROM mysql:8.3

# Set the working directory
WORKDIR /tmp

# Copy the SQL database to the working directory of the container
COPY *.sql /tmp/
#COPY world/*.dump /tmp/

COPY world.sql /docker-entrypoint-initdb.d

# Set the root password
ENV MYSQL_ROOT_PASSWORD my-secret-pw