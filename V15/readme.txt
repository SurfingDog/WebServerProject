本版本独立完成用户登录功能

登陆流程:
1:用户在首页点击登陆的超链接来到登陆页面
2:在登陆页面中输入用户名和密码并点击登录按钮
3:服务端处理登陆
4:响应登陆结果页面(登陆成功或失败)

实现:
1:在webapps/myweb下准备页面
    1.1:login.html 登陆页面
        这个页面的form表单action="./loginUser"
        表单中要求两个输入框，分别输入用户名和密码
    1.2:login_fail.html 登陆失败提示页面
        居中显示一行字:登陆失败，用户或密码不正确
    1.3:login_success.html 登陆成功提示页面
        居中提示一行字:登陆成功，欢迎回来!
2:在com.webserver.servlet中添加处理登陆的业务类:LoginServlet并完成service方法
  只有当用户名和密码都正确时响应登陆成功页面。
  需要将登陆信息与user.dat文件中的用户进行比对。
3:在ClientHandler处理请求环节再添加一个分支，如果请求路径对应的是登陆，则实例化
  LoginServlet并调用其service方法处理登陆。