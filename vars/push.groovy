def call(String project, String imageTag, String dockerHubUser){

        echo '''
        ██████╗     ██╗   ██╗    ███████╗    ██╗  ██╗
        ██╔══██╗    ██║   ██║    ██╔════╝    ██║  ██║
        ██████╔╝    ██║   ██║    ███████╗    ███████║
        ██╔═══╝     ██║   ██║    ╚════██║    ██╔══██║
        ██║          ╚██████╔╝    ███████║    ██║  ██║
        ╚═╝           ╚═════╝     ╚══════╝    ╚═╝  ╚═╝
        '''
    
        withCredentials([usernamePassword(
            credentialsId: 'dockerHubCred',
            passwordVariable: 'dockerHubPass',
            usernameVariable: 'dockerHubUser')]) {
    
            echo "Docker Login Successful for User: ${dockerHubUser}"
    
            sh "docker login -u ${dockerHubUser} -p ${env.dockerHubPass}"
        }
    
        sh "docker push ${dockerHubUser}/${project}:${imageTag}"
    
        echo '''
        ███████╗    ██╗   ██╗     ██████╗     ██████╗    ███████╗
        ██╔════╝    ██║   ██║    ██╔════╝    ██╔════╝    ██╔════╝
        ███████╗    ██║   ██║    ██║         ██║         █████╗
        ╚════██║    ██║   ██║    ██║         ██║         ██╔══╝
        ███████║    ╚██████╔╝    ╚██████╗    ╚██████╗    ███████╗
        ╚══════╝     ╚═════╝      ╚═════╝     ╚═════╝    ╚══════╝
        '''
    
}
