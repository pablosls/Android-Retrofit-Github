package ocean_android.com.br.ocean_10_06_2019

class GitHubResult (
        val items: List<Repository>
)

class Repository(
        val id:Long?,
        val name:String?,
        val full_name: String?,
        val owner: Owner

)

class Owner(
        val id :Long?,
        val login: String?,
        val avatar_url: String?
)