
ps -ef|grep lottery-1.0-SNAPSHOT.jar|awk '{print $2}'|xargs kill -9

mvn clean package

cp target/lottery-1.0-SNAPSHOT.jar ./lottery-1.0-SNAPSHOT.jar

nohup java -jar ./lottery-1.0-SNAPSHOT.jar > ./nohup.out &


