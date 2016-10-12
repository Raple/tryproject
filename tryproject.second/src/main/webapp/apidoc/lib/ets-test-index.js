/**
 * Created by kencery on 2015/12/28.
 */

var ets=window.ets||{};
ets.testboss=ets.testboss||{};

ets.testboss.testIndex=(function() {

    initialize = function () {
        $("#btnLoginin").click(function () {
            loinIn();
        });
        $("#btnLogout").click(function () {
            loginout();
        });
        $("#btngetMenu").click(function () {
            getMenu();
        });
        $("#btngetButton").click(function () {
            btngetButton();
        })
        $("#btngetMenuButton").click(function () {
            btngetMenuButton();
        })
        $("#btngetMenuButtonbyRuleId").click(function () {
            btngetMenuButtonbyRuleId();
        })
        $("#btngetcheckUser").click(function () {
            btngetcheckUser();
        })
        $("#btnresetPassword").click(function () {
            btnresetPassword();
        })

        $("#btngetResource").click(function () {
            btngetResource();
        })
        $("#btngetData").click(function () {
            btngetData();
        })
        $("#btnaddFunc").click(function () {
            btnaddFunc();
        })
        $("#btnCheckRole").click(function () {
            btnCheckRole();
        })
        $("#btnFuncRuleStart").click(function () {
            btnFuncRuleStart();
        })
        $("#btnFuncRuleForbid").click(function () {
            btnFuncRuleForbid();
        })
        $("#btnFuncRuleDelete").click(function () {
            btnFuncRuleDelete();
        })
        $("#btngetResourceInfo").click(function () {
            btngetResourceInfo();
        })
        $("#btngetRulebyRuleId").click(function () {
            btngetRulebyRuleId();
        })
        $("#btnEditFunc").click(function () {
            btnEditFunc();
        })
        $("#btnAddData").click(function () {
            btnAddData();
        })
        $("#btngetDatabyRuleId").click(function () {
            btngetDatabyRuleId();
        })
        $("#btneditData").click(function () {
            btneditData();
        })

    }

    //region---------------------------读取角色权限信息
    function btngetResource() {
        var para = {'ruleName': "", 'ruleIsenable': "1", 'pageSize': 2, 'pageIndex': 2};
        $.ajax({
            url: "/v1/rule/rulelist",
            data: para,
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnaddFunc() {
        var para = {'ruleName': "API测试测试事务", 'resourceId': '10,11,12,13', 'ruleDesc': "API测试"};
        $.ajax({
            url: "/v1/rule/addfunc",
            data: JSON.stringify(para),
            dataType: "json",
            type: "post",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnCheckRole() {
        $.ajax({
            url: "/v1/rule/getcheckrule",
            data: {rulename: "API测试测试事务", ruleId: "0"},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnFuncRuleStart() {
        var para = {'ruleId': '44'};
        $.ajax({
            url: "/v1/rule/funcrulestart",
            data: JSON.stringify(para),
            dataType: "json",
            type: "put",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnFuncRuleForbid() {
        var para = {'ruleId': '44'};
        $.ajax({
            url: "/v1/rule/funcruleforbid",
            data: JSON.stringify(para),
            dataType: "json",
            type: "put",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnFuncRuleDelete() {
        var para = {'ruleId': '44'};
        $.ajax({
            url: "/v1/rule/funcruledelete",
            data: JSON.stringify(para),
            dataType: "json",
            type: "put",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetResourceInfo() {
        $.ajax({
            url: "/v1/resource/getresourceinfo",
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetRulebyRuleId() {
        $.ajax({
            url: "/v1/rule/getrulebyruleId",
            data: {'ruleId': 1},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnEditFunc() {
        var para = {'ruleId': 5, 'ruleName': "API测试1111111111", 'resourceId': '4,8,10', 'ruleDesc': "API测试修改11"};
        $.ajax({
            url: "/v1/rule/editresource",
            data: JSON.stringify(para),
            dataType: "json",
            type: "put",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetData() {
        var para = {'ruleName': "", 'pageSize': 10, 'currentPage': 1};
        $.ajax({
            url: "/v1/rule/getrulerestaurant",
            data: para,
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnAddData() {
        var para = {'ruleName': "API数据权限测试", 'resourceId': '1,2,3', 'ruleDesc': "API数据权限测试"};
        $.ajax({
            url: "/v1/rule/adddata",
            data: JSON.stringify(para),
            dataType: "json",
            type: "post",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetDatabyRuleId() {
        $.ajax({
            url: "/v1/rule/getdatabyruleId",
            data: {'ruleId': 45},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btneditData() {
        var para = {'ruleId': 45, 'ruleName': "API数据权限测试修改", 'resourceId': '8,9,10', 'ruleDesc': "API测试修改修改"};
        $.ajax({
            url: "/v1/rule/editdata",
            data: JSON.stringify(para),
            dataType: "json",
            type: "put",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    //endregion
    //region---------------------------读取用户登录权限接口
    function loinIn() {
        var para = {'username': "admin", 'password': "111111", 'rememberMe': true};
        $.ajax({
            url: "/v1/login",
            data: JSON.stringify(para),
            dataType: "json",
            type: "post",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function loginout() {
        $.ajax({
            url: "/v1/logout",
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function getMenu() {
        $.ajax({
            url: "/v1/getmenu",
            data: {'userId': 1},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetButton() {
        $.ajax({
            url: "/v1/getbutton",
            data: {'userId': 1},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetMenuButtonbyRuleId() {
        $.ajax({
            url: "/v1/getmenubuttbyruleId",
            data: {'ruleId': 6},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetMenuButton() {
        $.ajax({
            url: "/v1/getmenubutton",
            data: {'userId': 6},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btngetcheckUser() {
        $.ajax({
            url: "/v1/getcheckuser",
            data: {'username': "admin", 'userid': '0'},
            dataType: "json",
            type: "get",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    function btnresetPassword() {
        var para = {'userId': '14', 'password': "111111"};
        $.ajax({
            url: "/boss/v1/resetpassword",
            data: JSON.stringify(para),
            dataType: "json",
            type: "post",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                readShow(data);
            }
        });
    }

    //endregion
    function readShow(data) {
        $("#show").html(JSON.stringify(data));
    }

    return {
        init: function (options) {
            initialize(); // 初始化方法
        }
    }
}())