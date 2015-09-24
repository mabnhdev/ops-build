# Copyright (C) 2015 Hewlett Packard Enterprise Development LP

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Other valid fields: BUILD_ID ID_LIKE ANSI_COLOR CPE_NAME
#                     HOME_URL SUPPORT_URL BUG_REPORT_URL
OS_RELEASE_FIELDS = "ID ID_LIKE NAME VERSION VERSION_ID PRETTY_NAME HOME_URL BUILD_ID"

HOME_URL="http://www.openswitch.net"

# Leting the code here if we want to go back to USER name approach
# def get_build_id(d):
#     import os
#     import pwd
#     return pwd.getpwuid(os.getuid())[0]
# BUILD_ID = "${@get_build_id(d)}"

BUILD_ID = "developer_image"


include build_info.conf
