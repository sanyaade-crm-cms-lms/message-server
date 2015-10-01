/*   Copyright (c) 2015 Magnet Systems, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.magnet.mmx.server.plugin.mmxmgmt.db;

import com.magnet.mmx.server.plugin.mmxmgmt.db.utils.BaseDbTest;
import com.magnet.mmx.server.plugin.mmxmgmt.db.utils.TestDataSource;
import com.magnet.mmx.server.plugin.mmxmgmt.search.endpoint.EndPointSearchOption;
import com.magnet.mmx.server.plugin.mmxmgmt.search.endpoint.EndPointSortOption;
import com.magnet.mmx.server.plugin.mmxmgmt.util.JIDUtil;
import com.magnet.mmx.server.plugin.mmxmgmt.web.ValueHolder;
import org.junit.ClassRule;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 */
public class EndPointSearchDAOImplTest {

  @ClassRule
  public static BaseDbTest.DataSourceResource dataSourceRule = new BaseDbTest.DataSourceResource(TestDataSource.APP_DATA_1, TestDataSource.USER_DATA_1, TestDataSource.DEVICE_DATA_1);

  private static ConnectionProvider connectionProvider = new BasicDataSourceConnectionProvider(dataSourceRule.getDataSource());


  @Test
  public void testSearch1() throws Exception {
    String appId = "AAABSNIBKOstQST7";
    EndPointSearchOption searchOption = EndPointSearchOption.ENDPOINT_STATUS;

    EndPointSortOption sortOption = EndPointSortOption.defaultSortOption();

    EndPointDAO endPointDAO = new EndPointDAOImpl(connectionProvider);
    ValueHolder holder = new ValueHolder();
    holder.setValue1(DeviceStatus.INACTIVE.name());
    SearchResult<EndPointEntity> result = endPointDAO.search(appId,searchOption, holder,sortOption, null);

    assertNotNull(result);

    List<EndPointEntity> entityList = result.getResults();
    int size = entityList.size();
    int expectedSize = 1;
    assertEquals("Result list is not matching", expectedSize, size);
  }


  @Test
  public void testSearch2() throws Exception {
    String appId = "AAABSNIBKOstQST7";
    EndPointSearchOption searchOption = EndPointSearchOption.ENDPOINT_NAME;

    EndPointSortOption sortOption = EndPointSortOption.defaultSortOption();

    EndPointDAO endPointDAO = new EndPointDAOImpl(connectionProvider);
    ValueHolder holder = new ValueHolder();
    holder.setValue1("Tablet");
    SearchResult<EndPointEntity> result = endPointDAO.search(appId,searchOption, holder,sortOption, null);

    assertNotNull(result);

    List<EndPointEntity> entityList = result.getResults();
    int size = entityList.size();
    int expectedSize = 1;
    assertEquals("Result list is not matching", expectedSize, size);
  }

  @Test
  public void testSearch2MOB_795() throws Exception {
    String appId = "AAABSNIBKOstQST7";
    EndPointSearchOption searchOption = EndPointSearchOption.ENDPOINT_NAME;

    EndPointSortOption sortOption = EndPointSortOption.defaultSortOption();

    EndPointDAO endPointDAO = new EndPointDAOImpl(connectionProvider);
    ValueHolder holder = new ValueHolder();
    holder.setValue1("Tablet");
    SearchResult<EndPointEntity> result = endPointDAO.search(appId,searchOption, holder,sortOption, null);

    assertNotNull(result);

    List<EndPointEntity> entityList = result.getResults();
    int size = entityList.size();
    int expectedSize = 1;
    assertEquals("Result list is not matching", expectedSize, size);

    EndPointEntity entity = entityList.get(0);
    UserEntity user = entity.getUserEntity();
    assertNotNull("Expecting a not null user", user);
    String userId = user.getUsername();
    int index = userId.indexOf(JIDUtil.APP_ID_DELIMITER);
    assertTrue("Found APP_ID_DELIMITER which was not expected", -1 == index);
  }

  @Test
  public void testSearch3() throws Exception {
    String appId = "AAABSNIBKOstQST7";
    EndPointSearchOption searchOption = EndPointSearchOption.ENDPOINT_DATE_CREATED;

    EndPointSortOption sortOption = EndPointSortOption.defaultSortOption();

    EndPointDAO endPointDAO = new EndPointDAOImpl(connectionProvider);
    ValueHolder holder = new ValueHolder();
    holder.setValue1(Long.toString(1411628400));
    holder.setValue2(Long.toString(1414220400));
    SearchResult<EndPointEntity> result = endPointDAO.search(appId,searchOption, holder,sortOption, null);

    assertNotNull(result);

    List<EndPointEntity> entityList = result.getResults();
    int size = entityList.size();
    int expectedSize = 1;
    assertEquals("Result list is not matching", expectedSize, size);
  }
}
