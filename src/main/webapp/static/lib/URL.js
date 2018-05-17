/**
 * Created by wangqiong on 2017/3/3.
 * 获取url请求的当前页面的路径path和请求参数query
 * path:function 获取当前页面的路径
 * query:function 获取当前请求的参数
 * stringify:function(query) 传入参数对象或参数字符串返回新生成的url字符串(页面路径还是当前的页面路径)
 */
window.URL={
    path:function(){
        return location.protocol+"//"+location.host+location.pathname;
    },
    query:function(){
        return location.search.replace("?","").split("&").filter(function(kv){
            return kv;
        }).reduce(function(target,kv){
            kv=kv.split("=");
            target[kv[0]]=kv[1];
            return target;
        },{});
    },
    stringify:function(query){
        if(typeof query === "object"){
            query = Object.keys(query).map(function(key){
                return key+"="+query[key];
            }).join("&");
        }
        return this.path()+"?"+query;
    }
};