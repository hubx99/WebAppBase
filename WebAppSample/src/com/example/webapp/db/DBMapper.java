package com.example.webapp.db;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.webapp.bean.User;

public interface DBMapper {
	@Select("SELECT user.tenant_id, user.id, user.password FROM mst_user user INNER JOIN mst_tenant tenant ON user.tenant_id = tenant.id WHERE user.tenant_id = #{user.tenantId} AND user.id = #{user.id} AND user.password=#{user.password} AND user.enable IS TRUE AND tenant.enable IS TRUE")
	@Results({ //
			@Result(property = "tenantId", column = "tenant_id") //
	})
	public User selectUser(@Param("user") User user);

	@Select("SELECT id FROM mst_user WHERE tenant_id = #{user.tenantId} AND visible IS TRUE AND enable IS TRUE")
	public List<User> selectUsers(@Param("user") User user);

	@Select("SELECT id, name, role_id FROM mst_user WHERE tenant_id = #{user.tenantId} AND visible IS TRUE AND enable IS TRUE")
	public List<Map<String, Object>> selectUsers2(@Param("user") User user);

	@Select("SELECT id, name, role_id FROM mst_user WHERE tenant_id = #{user.tenantId} AND id = #{id} AND visible IS TRUE AND enable IS TRUE")
	public Map<String, Object> selectUsersOne(@Param("user") User user, @Param("id") String id);

	@Update("UPDATE mst_user SET name=#{values.name}, role_id=#{values.role_id} WHERE tenant_id = #{user.tenantId} AND id = #{id} AND visible IS TRUE AND enable IS TRUE")
	public int updateUser(@Param("user") User user, @Param("id") String id,
			@Param("values") Map<String, Object> values);

	@Insert("INSERT INTO mst_user (tenant_id, id, password, name, role_id) VALUES (#{user.tenantId}, #{id}, #{values.password}, #{values.name}, #{values.role_id})")
	public int insertUser(@Param("user") User user, @Param("id") String id,
			@Param("values") Map<String, Object> values);

	@Select("SELECT COUNT(*) != 0 FROM mst_user WHERE tenant_id = #{user.tenantId} AND id = #{id}")
	public boolean existsUser(@Param("user") User user, @Param("id") String id);
}
