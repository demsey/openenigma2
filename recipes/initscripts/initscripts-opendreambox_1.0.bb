DESCRIPTION = "SysV init scripts (stripped) for opendreambox"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
SECTION = "base"
PRIORITY = "required"
DEPENDS = "makedevs"
RDEPENDS = "makedevs"
PROVIDES = "initscripts"
RPROVIDES_${PN} = "initscripts"
LICENSE = "GPL"
PR = "r20"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/${P}', '${FILE_DIRNAME}/initscripts-${PV}', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://halt \
           file://umountfs \
           file://devpts.sh \
           file://devpts \
           file://reboot \
           file://single \
           file://sendsigs \
           file://rmnologin \
           file://umountnfs.sh \
           file://sysfs.sh \
           file://netmount.sh \
           file://var.tar.gz.default \
           file://bootup"

SRC_URI_append_dm8000 = " file://fscking.raw"

KERNEL_VERSION = ""

do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${sysconfdir}/rc0.d
	install -d ${D}${sysconfdir}/rc1.d
	install -d ${D}${sysconfdir}/rc2.d
	install -d ${D}${sysconfdir}/rc3.d
	install -d ${D}${sysconfdir}/rc4.d
	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}${sysconfdir}/rc6.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/default/volatiles

	install -m 0755    ${WORKDIR}/halt		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/reboot		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rmnologin	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/sendsigs		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/single		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/devpts.sh	${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/devpts		${D}${sysconfdir}/default
	install -m 0755    ${WORKDIR}/sysfs.sh		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/bootup		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/var.tar.gz.default ${D}${sysconfdir}/var.tar.gz
#
# Install device dependent scripts
#
	if [ "${MACHINE}" = "dm600pvr" -o "${MACHINE}" = "dm500plus" ]; then
		head -n 4 ${WORKDIR}/umountfs > ${D}${sysconfdir}/init.d/umountfs
		echo "cd /tmp" >> ${D}${sysconfdir}/init.d/umountfs
		tail -n 14 ${WORKDIR}/umountfs >> ${D}${sysconfdir}/init.d/umountfs
		chmod 0755 ${D}${sysconfdir}/init.d/umountfs
		ln -sf /usr/bin/showshutdownpic ${D}${sysconfdir}/rc0.d/S89showshutdownpic
	else
		install -m 0755 ${WORKDIR}/umountfs	${D}${sysconfdir}/init.d/umountfs
		install -d ${D}${sysconfdir}/network/if-up.d
		install -m 0755 ${WORKDIR}/netmount.sh  ${D}${sysconfdir}/network/if-up.d/02netmount
		install -d ${D}${sysconfdir}/network/if-down.d
		install -m 0755 ${WORKDIR}/umountnfs.sh	${D}${sysconfdir}/network/if-down.d/02umountnfs
	fi

	if [ "${MACHINE}" = "dm8000" ]; then
		install -m 0755 ${WORKDIR}/fscking.raw ${D}${sysconfdir}/
	fi
#
# Create runlevel links
#
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc2.d/S99rmnologin
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc3.d/S99rmnologin
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc4.d/S99rmnologin
	ln -sf		../init.d/rmnologin	${D}${sysconfdir}/rc5.d/S99rmnologin
	ln -sf		../init.d/sendsigs	${D}${sysconfdir}/rc6.d/S20sendsigs
	ln -sf		../init.d/umountfs	${D}${sysconfdir}/rc6.d/S40umountfs
	ln -sf		../init.d/reboot	${D}${sysconfdir}/rc6.d/S90reboot
	ln -sf		../init.d/sendsigs	${D}${sysconfdir}/rc0.d/S20sendsigs
	ln -sf		../init.d/umountfs	${D}${sysconfdir}/rc0.d/S40umountfs
	ln -sf		../init.d/halt		${D}${sysconfdir}/rc0.d/S90halt
	# udev will run at S03 if installed
	ln -sf		../init.d/sysfs.sh	${D}${sysconfdir}/rcS.d/S02sysfs
	ln -sf		../init.d/devpts.sh	${D}${sysconfdir}/rcS.d/S38devpts.sh
	ln -sf		../init.d/bootup	${D}${sysconfdir}/rcS.d/S04bootup
}
