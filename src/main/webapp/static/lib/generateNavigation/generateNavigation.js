/*
* 生成左侧导航栏
* option:
*   datas生成左侧导航栏的数据
*   extraAttr 元素上面生成自定义属性
*       {"key":function(data){},"key1":function(data){}}
*           使用键值对形式生成自定义属性,
*               key是自定义属性名,
*               function(data)
*                   data是生成当前元素的数据
*                   返回将要生成的属性的属性值
*   onSelected 元素选中事件
*       params:data 生成当前节点的数据,
*              datas 生成插件使用的所有的数据
*              this 当前点击的节点
*   headRenderFn用来生成生成每个元素的回调函数
*       params:data 生成当前节点的数据
* */
(function($){
    if($.fn.accordion){
        return;
    }
    var setMethods={

    };
    var getMethods={

    };
    $.fn.accordion=function(){
        var args=arguments,params,method;
        if(!args.length|| typeof args[0] == 'object'){
            return this.each(function(idx){
                var $self=$(this);
                $self.data('accordion',$.extend(true,{},$.fn.accordion["default"],args[0]));
                params=$self.data('accordion');
                _init.call( $self,params);
                _render.call($self);
            });
        }else{
            if(!$(this).data('accordion')){
                throw new Error('You has not init accordion!');
            }
            params=Array.prototype.slice.call(args,1);
            if (setMethods.hasOwnProperty(args[0])){
                method=setMethods[args[0]];
                return this.each(function(idx){
                    var $self=$(this);
                    method.apply($self,params);
                    _render.call($self);
                });
            }else if(getMethods.hasOwnProperty(args[0])){
                method=getMethods[args[0]];
                return method.apply(this,params);
            }else{
                throw new Error('There is no such method');
            }
        }
    }
    $.fn.accordion["default"]={
        datas:[],
        extraAttr:{},
        headRenderFn:function(data){
            return data.text;
        },
        onSelected:function(data,datas){}
    }
    function _init(params){
        return this;
    }
    function _render(){
        var $self=this,
            params=$self.data("accordion"),
            firsts=params.datas;
        $self.addClass("accordion").html(
            firsts.map(function(first){
                var seconds=first.children||[];
                return $("<div/>",{
                    "class": "accordion-item accordion-first"+(_isActive(first)?" active":"")
                }).append(
                    _generateHeader.call($self,first,params.datas),
                    $("<div/>",{
                        "class":"accordion-content"
                    }).append(
                        seconds.map(function(second){
                            var thirds=second.children||[];
                            return $("<div/>",{
                                "class":"accordion-item accordion-second"+(_isActive(second)?" active":"")
                            }).append(
                                _generateHeader.call($self,second,params.datas),
                                $("<div/>",{
                                    "class":"accordion-content"
                                }).append(
                                    thirds.map(function(third){
                                        return $("<div/>",{
                                            "class":"accordion-item accordion-third"+(_isActive(third)?" active":"")
                                        }).append(
                                            _generateHeader.call($self,third,params.datas)
                                        )
                                    })
                                )
                            )
                        })
                    )
                )
            })
        )
    }
    function _generateHeader(data,datas){
        var $self=this,
            params=$self.data("accordion");
        var header=$("<div/>",{
            "class":"accordion-head",
            "html":params.headRenderFn(data),
            "click":function(){
                _clearActive(params.datas);
                data._active=true;
                _render.call($self);
                params.onSelected.call(this,data,datas);
            }
        });
        header.attr(Object.keys(params.extraAttr).reduce(function(target,attr){
            target[attr]=params.extraAttr[attr](data);
            return target;
        },{}));
        return header;
    }
    function _clearActive(datas){
        clearActive(datas);
        function clearActive(datas){
            if(!datas){
                return;
            }
            datas.forEach(function(data){
                data._active=false;
                clearActive(data.children);
            })
        }
    }
    function _isActive(data){
        var active=false;
        isActive(data);
        return active;
        function isActive(data){
            if(data._active){
                active=true;
            }
            (data.children||[]).forEach(function(data){
                isActive(data);
            })
        }
    }
})(jQuery);
