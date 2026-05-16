def call(String Project, String ImageTag, String dockerHubUser){
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        echo "${env.dockerHubUser} ${env.dockerHubPass}"
        sh "docker login -u ${dockerHubUser -p ${env.dockerHubPass}"
    }
    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}