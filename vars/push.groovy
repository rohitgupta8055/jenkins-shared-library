def call(String credentialsId, String imageName, String imageTag){

            echo '''
            ██████╗     ██╗   ██╗    ███████╗    ██╗  ██╗
            ██╔══██╗    ██║   ██║    ██╔════╝    ██║  ██║
            ██████╔╝    ██║   ██║    ███████╗    ███████║
            ██╔═══╝     ██║   ██║    ╚════██║    ██╔══██║
            ██║          ╚██████╔╝    ███████║    ██║  ██║
            ╚═╝           ╚═════╝     ╚══════╝    ╚═╝  ╚═╝
            '''
        
            withCredentials([usernamePassword(
                credentialsId: credentialsId,
                passwordVariable: 'dockerHubPass',
                usernameVariable: 'dockerHubUser')]) {
        
                echo "Docker Login Successful for User: ${env.dockerHubUser}"
        
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        
                sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
            }
        
            echo '''
            ███████╗    ██╗   ██╗     ██████╗     ██████╗    ███████╗
            ██╔════╝    ██║   ██║    ██╔════╝    ██╔════╝    ██╔════╝
            ███████╗    ██║   ██║    ██║         ██║         █████╗
            ╚════██║    ██║   ██║    ██║         ██║         ██╔══╝
            ███████║    ╚██████╔╝    ╚██████╗    ╚██████╗    ███████╗
            ╚══════╝     ╚═════╝      ╚═════╝     ╚═════╝    ╚══════╝
            '''
        
}
