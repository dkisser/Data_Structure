namespace java protocol.thrift

struct QryResult {

        /**

        *返回码, 1成功，0失败

        */

        1:i32 code;

        /**

        *响应信息

        */

        2:string msg;

}

service TestQry{

        /**

        * 测试查询接口，当qryCode值为1时返回"成功"的响应信息，qryCode值为其他值时返回"失败"的响应信息

        * @param qryCode测试参数

        */

        QryResult qryTest(1:i32 qryCode)

}