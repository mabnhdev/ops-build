SUMMARY = "Halon System Daemon (sysd)"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;beginline=0;endline=14;md5=9bf02f5d4de26e44a8954673dead2ee0"

DEPENDS = "halonutils config-yaml halon-ovsdb"

SRC_URI = "git://git.openhalon.io/openhalon/sysd;protocol=https;preserve_origin=1 \
           file://sysd.service \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/sysd.service ${D}${systemd_unitdir}/system
}

do_configure_prepend() {
    export HWDESC_FILES_PATH=${sysconfdir}/halon/platform
    export HWDESC_FILE_LINK_PATH=${sysconfdir}/halon
    export HWDESC_FILE_LINK=${sysconfdir}/halon/hwdesc
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "sysd.service"

inherit halon cmake systemd pkgconfig
