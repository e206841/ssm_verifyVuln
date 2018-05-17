/**
 * Created by wangqiong on 2017/3/7.
 */
/**
 * 抓取表单中所有的数据填充到json中
 * warning:因为提交form-data类型的表单有更好的办法 https://developer.mozilla.org/zh-CN/docs/Web/API/XMLHttpRequest/Using_XMLHttpRequest
 * 所以这里只有非文件提交的写法
 * 相同名称的字段会生成每个值以逗号分隔的字符串
 * @param form  将要抓取的表单
 * @returns {*|jQuery}
 */
function getFormData(form){
    var plainData = $(form).serializeArray().reduce(function (previous, item) {
        var key = item.name;
        var value = item.value;
        if (previous[key]) {
            previous[key].push(value);
        } else {
            previous[key] = [value];
        }
        return previous;
    }, {});
    Object.keys(plainData).forEach(function (key) {
        plainData[key] = plainData[key].toString().trim();
    });
    return plainData;
}
/**
 * 向表单中填充数据(文件类型的不支持填充)
 * @param form  填充的表单
 * @param data  填充的数据
 */
function fillFormData(form,data){
    Object.keys(data).forEach(function (key) {
        var value=data[key];
        if(value===0){
            value+="";
        }else if(!value){
            value="";
        }else{
            value+="";
        }
        $("[name=" + key + "]",$(form)).val(value.split(","));
    });
}

/**
 * 向下拉列表填充数据
 * @param select    下拉列表
 * @param fillData  填充的数据
 * @param valueKey  value值(默认id)
 * @param textKey   显示文本(默认name)
 */
function fillSelect(select,fillData,valueKey,textKey){
    if(fillData && fillData.length > 0){
        valueKey=valueKey||"id";
        textKey=textKey||"name";
        select.length = 1;
        $(select).append(fillData.map(function(data){
            return $("<option/>",{
                value:data[valueKey],
                text:data[textKey],
                selected:!!data.selected
            })
        }))
    }
}

