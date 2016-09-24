package com.jkamcc.lastfm.portlet.user;

import com.liferay.compat.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

/**
 * @author juancarrillo
 */
public class UserImporterPortlet extends MVCPortlet {

    private static final int USER_SHA = 0;
    private static final int SEX = 1;
    private static final int AGE = 2;
    private static final int COUNTRY = 3;

    private static final String DEFAULT_STRING = "LAST_FM";

    public void importUsers(ActionRequest request, ActionResponse response) {

        String filePath = ParamUtil.getString(request, "filePath");

        if (Validator.isNull(filePath)) {
            SessionErrors.add(request, "File Not Found");
        } else {
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
                importUsers(filePath, serviceContext);
            } catch (PortalException e) {
                _log.error(e);
            } catch (SystemException e) {
                _log.error(e);
            } catch (FileNotFoundException e) {
                SessionErrors.add(request, "File Not Found");
            } catch (IOException e) {
                _log.error(e);
            }
        }
    }

    private void importUsers(String csvFile, ServiceContext serviceContext) throws IOException {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = StringPool.TAB;

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] userData = line.split(cvsSplitBy, -1);

                try {
                    saveUser(userData, serviceContext);
                    _log.info("created user with uuid "+ userData[USER_SHA]);
                } catch (SystemException e) {
                    _log.error("error creating user with uuid "+ userData[USER_SHA]);
                    _log.error(e.getMessage());
                } catch (PortalException e) {
                    _log.error("error creating user with uuid "+ userData[USER_SHA]);
                    _log.error(e.getMessage());
                }
            }

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private User saveUser(String[] userData, ServiceContext serviceContext) throws SystemException, PortalException {

        /* Attributes from Dataset */
        String guid = GetterUtil.getString(userData[USER_SHA]);
        boolean sex = GetterUtil.getBoolean(userData[SEX]);
        int age = GetterUtil.getInteger(userData[AGE]);
        String country = GetterUtil.getString(userData[COUNTRY]);

        /* Required Attributes */
        long creatorUserId = 0;
        long companyId = serviceContext.getCompanyId();
        boolean autoPassword = true;
        boolean autoScreenName = true;
        String emailAddress = guid + StringPool.AT + "test.com.dev1";
        long[] groupIds = null;
        long[] organizationIds = null;
        long[] roleIds = null;
        long[] userGroupIds = null;
        String password = StringPool.BLANK;
        String screenName = StringPool.BLANK;
        String openId = StringPool.BLANK;
        long facebookId = 0;
        String jobTitle = StringPool.BLANK;
        int prefixId = 0;
        int suffixId = 0;
        String firstName = DEFAULT_STRING;
        String middleName = DEFAULT_STRING;
        String lastName = DEFAULT_STRING;
        Calendar birthDate = getBirthDateFromAge(age);

        if (serviceContext == null) {
            serviceContext = new ServiceContext();
        }

        serviceContext.setUuid(guid);

        User user = UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password, password,
                autoScreenName, screenName, emailAddress, facebookId, openId, serviceContext.getLocale(), firstName,
                middleName, lastName, prefixId, suffixId, sex, birthDate.get(Calendar.MONTH),
                birthDate.get(Calendar.DAY_OF_MONTH), birthDate.get(Calendar.YEAR), jobTitle, groupIds, organizationIds,
                roleIds, userGroupIds, false, serviceContext);

        return user;
    }

    public Calendar getBirthDateFromAge(int age) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - age);
        return calendar;
    }

    Log _log = LogFactoryUtil.getLog(UserImporterPortlet.class);

}
