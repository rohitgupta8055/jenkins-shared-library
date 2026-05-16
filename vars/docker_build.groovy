def call(String ProjectName, String ImageName, String DockerHubUser){
    echo "This is building the code"
    sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageName} ."
}