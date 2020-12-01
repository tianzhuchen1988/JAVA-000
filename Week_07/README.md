### 按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率
```java
   /**
     * 使用动态拼接SQL方式插入100万条数据测试
     *
     * @author chentz
     * @date 2020/12/1 10:45
     * @param
     * @return void
     */
    public void insertByDynamicSql() {
        Connection conn = getConnection();
        // 开时时间
        Long begin = new Date().getTime();
        // sql前缀
        String prefix = "INSERT INTO tb_order (order_no, user_id, address, mobile, product_code, price, product_quantity, order_amount," +
                "status, create_time, update_time, delete_sign) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 10000; j++) {
                    // 构建sql后缀
                    suffix.append("(" + SnowflakeIdUtil.getIdUtilNo() + "," + SnowflakeIdUtil.getIdUtilNo() + "," + "'test'," +
                            "'18120868629'," + SnowflakeIdUtil.getIdUtilNo() + "," + 0.01 + "," + 1 + "," + 0.01 + ","
                            + 1 + "," + new Date().getTime() + "," + new Date().getTime() + "," + 0 + "),");
                }
                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();
        // 耗时
        System.out.println("cast : " + (end - begin) / 1000 + " s");
    }
```
