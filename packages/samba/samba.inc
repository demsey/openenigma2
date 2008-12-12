SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "readline virtual/libiconv"

SRC_URI = "http://samba.org/samba/ftp/stable/samba-${PV}.tar.gz \
           file://configure.patch;patch=1"

SRC_URI_append_opendreambox = " \
	file://smb.conf \
	file://01samba-kill \
	file://01samba-start"

S = "${WORKDIR}/samba-${PV}/source"

inherit autotools

EXTRA_OECONF='--disable-cups --with-readline=${STAGING_LIBDIR}/.. \
              --with-libiconv=${STAGING_LIBDIR}/.. \
	      --without-ads --without-automount --with-smbmount'

PACKAGES =+ "libsmbclient libsmbclient-dev cifs cifs-doc smbfs smbfs-doc"
PACKAGES =+ "${@base_conditional('DISTRO', 'opendreambox', ' sambaserver', '', d)}"
FILES_smbfs = "${bindir}/smbmount ${bindir}/smbumount ${bindir}/smbmnt ${base_sbindir}/mount.smbfs ${base_sbindir}/mount.smb"
FILES_smbfs-doc = "${mandir}/man8/smbmount.8 ${mandir}/man8/smbumount.8 ${mandir}/man8/smbmnt.8"
FILES_cifs = "${base_sbindir}/mount.cifs ${base_sbindir}/umount.cifs"
FILES_cifs-doc = "${mandir}/man8/mount.cifs.8 ${mandir}/man8/umount.cifs.8"
FILES_libsmbclient = "${libdir}/libsmbclient.so.*"
FILES_libsmbclient-dev = "${libdir}/libsmbclient.so ${includedir}"
FILES_sambaserver = "${sbindir}/smbd ${sbindir}/nmbd ${libdir}/charset/*.so ${libdir}/*.dat \
	/etc/samba/smb.conf /etc/samba/private \
	/etc/network/if-up.d/01samba-start /etc/network/if-down.d/01samba-kill"
CONFFILES_sambaserver = "/etc/samba/smb.conf"

do_configure_prepend () {
	./script/mkversion.sh
	if [ ! -e acinclude.m4 ]; then
		touch aclocal.m4	
		cat aclocal.m4 > acinclude.m4
	fi
}

do_compile () {
	oe_runmake proto_exists
	base_do_compile
	${CC} client/mount.cifs.c -o mount.cifs
}

do_install_append() {
	mv ${D}${libdir}/libsmbclient.so ${D}${libdir}/libsmbclient.so.0
	ln -sf libsmbclient.so.0 ${D}${libdir}/libsmbclient.so
	mkdir -p ${D}${base_sbindir}
	rm -f ${D}${sbindir}/mount.smbfs ${D}${base_sbindir}/mount.smbfs
	ln -sf ${bindir}/smbmount ${D}${base_sbindir}/mount.smb
	ln -sf ${bindir}/smbmount ${D}${base_sbindir}/mount.smbfs
	rm -f ${D}${bindir}/*.old
	rm -f ${D}${sbindir}/*.old
	install -c -m 755 mount.cifs  ${D}${base_sbindir}/mount.cifs
	[ -f ${D}${sbindir}/mount.cifs ] && mv ${D}${sbindir}/mount.cifs ${D}${base_sbindir}/
	[ -f ${D}${sbindir}/umount.cifs ] && mv ${D}${sbindir}/umount.cifs ${D}${base_sbindir}/
}

do_install_prepend_opendreambox() {
	install -c -m 644 ${WORKDIR}/smb.conf ../examples/smb.conf.default
}

do_install_append_opendreambox() {
	install -d ${D}/etc/samba/private
	install -d ${D}/etc/network/if-down.d
	install -m 0755 ${WORKDIR}/01samba-kill ${D}/etc/network/if-down.d
	install -d ${D}/etc/network/if-up.d
	install -m 0755 ${WORKDIR}/01samba-start ${D}/etc/network/if-up.d
}

do_stage() {
	install -m 0644 include/libsmbclient.h ${STAGING_INCDIR}
	oe_libinstall -C bin -a -so libsmbclient ${STAGING_LIBDIR}
}
