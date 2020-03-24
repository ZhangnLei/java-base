/*
 * Copyright  (c) 2020
 * @Author: Jetzhu 512704820@qq.com
 * @LastModified:2020-01-20T19:11:34.820+08:00
 */
package mrzhang.utils;
import com.sun.scenario.effect.impl.prism.ps.PPStoPSWDisplacementMapPeer;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text + key);
        //System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verifyMd5(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String body="{\"listBody\":[{\"tenantsNo\":\"SCRCU\",\"projectNo\":\"noProjectNo\",\"operatorId\":\"127600\",\"operatorName\":\"测试用户\",\"bizReqrmntNo\":\"\",\"bizReqrmntNm\":\"\",\"bizReqrmntTypCdList\":[],\"bizReqrmntStatusCdList\":[],\"sysAnalystsId\":\"\",\"bizAnalystsId\":\"\",\"reqrmntPutFwdPartyDeptId\":\"\",\"reqrmntIntrfcPersonId\":\"\",\"putFwdDt\":\"\",\"expectOnlineDt\":\"\",\"queryType\":\"\",\"pageNum\":1,\"pageSize\":10}],\"pageNum\":1,\"pageSize\":10,\"total\":0,\"token\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBkY2l0IiwidXNlcl9uYW1lIjoiMTU1MzQiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTgxNTEzNTI5LCJhdXRob3JpdGllcyI6WyJQTU8iLCJST0xFX1VTRVIiLCJuZXdfYnVzaW5lc3NNYW5hZ2UiLCJZV1hRX1BRIiwiWVdYUV9TQSIsIllXWFFfQkEiLCJ0ZXN0cm9sZWNvZGUiLCJpbnRfbWFuYWdlbWVudCIsIkJBX2ludGVyZmFjZV91c2VyIiwiUk9MRV9PUkciLCJZV1hRX1Byb2R1Y3REaXJlY3RvciJdLCJqdGkiOiIxYzhlYzFhMy03MmMzLTQzYWItODE5OC1lYjBjNzZmNDgyY2IiLCJjbGllbnRfaWQiOiJkY2l0In0.60vVUhBmR2DoHChs4bXh441-Oo7cN0oKegzL0svqEJk\"}}";
        String authorization="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBkY2l0IiwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTgxNTEwMTc0LCJhdXRob3JpdGllcyI6WyJXQlpZT1RNIiwiUk9MRV9DT0NfQUxMIiwiWVdYUV9TQSIsImh1aWppX3piIiwiUk9MRV9PUkciLCJoZWRkZCIsIlBNTyIsIlJPTEVfVVNFUiIsIllXWFFfUFEiLCJ0ZXN0QmRlbWFuZCIsIllXWFFfQkEiLCJ0ZXN0bmV3ZGVtYW5kbWFuYWdlIiwid2Vla0FwcHJvdmVyIiwiWVdYUV9Qcm9kdWN0RGlyZWN0b3IiXSwianRpIjoiZTljNTBhZTEtODhjNy00YmJmLWE4ODUtZmJhMDMyYTEzZGE4IiwiY2xpZW50X2lkIjoiZGNpdCJ9.IgHiVoPim_VvtNAR2GWKW7vr7dmxUgA6A-CmoIf92G4";
        String authorization1="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSBkY2l0IiwidXNlcl9uYW1lIjoiemh1ZGVqdW4wOCIsInNjb3BlIjpbInNlcnZlciJdLCJleHAiOjE1ODA0OTQ5MzQsImF1dGhvcml0aWVzIjpbIk5vciIsIlJPTEVfVVNFUiJdLCJqdGkiOiI1MTJiNzQxYy1hNWU0LTQxZDItYjQ0Ni1jOGRhNzQ4M2I5ODQiLCJjbGllbnRfaWQiOiJkY2l0In0.EOywnmmYi5Wcukv4a1_mI3vqmU8nIM2kWPADkP0H7C";

        String key="dcit";

        try {
//            System.out.println(md5(body, key));
            System.out.println(md5(body+authorization, key));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}