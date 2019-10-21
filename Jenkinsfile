node('master')
{
stage('git checkout')
{
git 'https://github.com/Mani9257/ING-BookLib-Java.git'
}
stage('java build')
{
sh '/opt/maven/bin/mvn clean deploy sonar:sonar -Dsonar.password=admin -Dsonar.login=admin'​
}
stage('Running java backend application')
{
sh 'export JENKINS_NODE_COOKIE=dontKillMe ;nohup java -jar $WORKSPACE/target/*.jar &'​
}
}
