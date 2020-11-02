学习笔记

作业中基于netty的网关中，使用了OkHttp实现了向后端服务发起http请求调用\n
实现了filter, 在真正向后端服务发起http请求时, 添加"nio=chentz"的请求头，并拼接在请求后端服务的url上
