post "/new-user", forward: "/WEB-INF/groovy/post.groovy"
get "/user/@id", forward: "/WEB-INF/groovy/get.groovy?id=@id"