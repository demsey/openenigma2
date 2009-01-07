export IMAGE_BASENAME = "dreambox-image"

OPENDREAMBOX_COMMON = "task-boot \
	opkg-nogpg dropbear \
	ncurses joe mc vsftpd timezones-alternative \
	netkit-base fakelocale dreambox-bootlogo \
	dreambox-dccamd dreambox-keymaps dvbsnoop \
	dreambox-compat tuxbox-common mrouted smartmontools hddtemp \
	hotplug-ng autofs gdbserver dreambox-feed-configs"

OPENDREAMBOX_COMMON_D = "util-linux e2fsprogs \
	ppp module-init-tools"

OPENDREAMBOX_COMMON_R = "util-linux-sfdisk util-linux-fdisk e2fsprogs-mke2fs \
	e2fsprogs-e2fsck ppp module-init-tools-depmod \
	base-files-doc"

# experimental packages
OPENDREAMBOX_EXPERIMENTAL = "python-twisted enigma2 aio-grab"
OPENDREAMBOX_EXPERIMENTAL_R = "enigma2-plugin-systemplugins-frontprocessorupgrade \
	enigma2-plugin-systemplugins-softwareupdate \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-extensions-cutlisteditor \
	enigma2-plugin-systemplugins-configurationbackup \
	enigma2-plugin-systemplugins-satfinder \
	enigma2-plugin-systemplugins-videotune \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-graphmultiepg \
	enigma2-plugin-systemplugins-skinselector \
	enigma2-plugin-extensions-pictureplayer \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkwizard \
	enigma2-streamproxy ethtool \
	enigma2-defaultservices \
	python-twisted-web python-twisted python-crypt python-pycrypto \
	python-netserver python-pickle python-pkgutil \
	python-twisted-core python-twisted-protocols \
	dreambox-blindscan-utils"

#	enigma2-plugin-extensions-webinterface is disabled until we fixed it to use twisted-web instead of twisted-web2

# legacy tuxbox stuff (enigma, plugins, ...)
OPENDREAMBOX_TUXBOX = "enigma ipkgpl"
OPENDREAMBOX_TUXBOX_D = "tuxbox-plugins tuxbox-plugins-enigma links-dream"
OPENDREAMBOX_TUXBOX_R = " \
	tuxbox-plugin-snake     tuxbox-plugin-tuxmail \
	tuxbox-plugin-lcdcirc   tuxbox-plugin-soko      tuxbox-plugin-tuxtxt \
	tuxbox-plugin-sol       tuxbox-plugin-vierg  	tuxbox-plugin-master \
	tuxbox-plugin-solitair  tuxbox-plugin-yahtzee 	tuxbox-plugin-mines  \
	tuxbox-plugin-tank  	tuxbox-plugin-pacman    tuxbox-plugin-tetris \
	tuxbox-plugin-satfind   tuxbox-plugin-tuxcom 	links-dream-plugin \
	links-dream-plugin enigma-plugin-dreamdata"

OPENDREAMBOX_TUXBOX_R_dm600pvr = " \
	tuxbox-plugin-snake     tuxbox-plugin-tuxmail \
	tuxbox-plugin-soko      tuxbox-plugin-tuxtxt \
	tuxbox-plugin-sol       tuxbox-plugin-vierg  	tuxbox-plugin-master \
	tuxbox-plugin-solitair  tuxbox-plugin-yahtzee 	tuxbox-plugin-mines  \
	tuxbox-plugin-tank  	tuxbox-plugin-pacman    tuxbox-plugin-tetris \
	tuxbox-plugin-tuxcom 	links-dream-plugin 	enigma-blindscan"

OPENDREAMBOX_TUXBOX_R_dm500plus = " \
	tuxbox-plugin-snake     tuxbox-plugin-tuxmail \
	tuxbox-plugin-soko      tuxbox-plugin-tuxtxt \
	tuxbox-plugin-sol       tuxbox-plugin-vierg  	tuxbox-plugin-master \
	tuxbox-plugin-solitair  tuxbox-plugin-yahtzee 	tuxbox-plugin-mines  \
	tuxbox-plugin-tank  	tuxbox-plugin-pacman    tuxbox-plugin-tetris \
	tuxbox-plugin-tuxcom 	links-dream-plugin	enigma-blindscan"

# dvb api specific stuff
OPENDREAMBOX_V2_ONLY = "dreambox-dvb-tools tuxbox-stream"
OPENDREAMBOX_V3_ONLY = "dreambox-dvb-tools-v3 sctzap dvbtraffic"

# enigma languages
# disabled: enigma-locale-ar enigma-locale-sr enigma-locale-ur
ENIGMA_LANGUAGE = "enigma-locale-cs enigma-locale-da \
	enigma-locale-de enigma-locale-el enigma-locale-es enigma-locale-et \
	enigma-locale-fi enigma-locale-fr enigma-locale-hr enigma-locale-hu \
	enigma-locale-is enigma-locale-it enigma-locale-lt enigma-locale-nl \
	enigma-locale-no enigma-locale-pl enigma-locale-pt enigma-locale-ro \
	enigma-locale-ru enigma-locale-sk enigma-locale-sl \
	enigma-locale-sv enigma-locale-tr"

OPENDREAMBOX_TUXBOX_R += " ${ENIGMA_LANGUAGE}"
OPENDREAMBOX_TUXBOX_R_dm600pvr += " ${ENIGMA_LANGUAGE}"
OPENDREAMBOX_TUXBOX_R_dm500plus += " ${ENIGMA_LANGUAGE}"

MODEM_SUPPORT = "enigma-modem"
MODEM_SUPPORT_R = "kernel-module-crc-ccitt kernel-module-ppp-async \
	kernel-module-ppp-generic \
	kernel-module-slhc update-modules"

WLAN_SUPPORT = "wireless-tools wlan-rt73 zd1211b wpa-supplicant"
WLAN_SUPPORT_R = "enigma2-plugin-systemplugins-wirelesslan"

WLAN_MADWIFI = "madwifi-ng"
WLAN_MADWIFI_R = "madwifi-ng-modules madwifi-ng-tools"

DVDPLAYER_SUPPORT_R = "enigma2-plugin-extensions-dvdplayer"

DVDBURN_SUPPORT_R = "enigma2-plugin-extensions-dvdburn dvd+rw-tools dvdauthor mjpegtools cdrkit python-imaging projectx"

CDPLAYER_SUPPORT_R = "kernel-module-cdfs libcddb libcdio enigma2-plugin-extensions-cdinfo"

# now machine specific:
OPENDREAMBOX_COMMON_MACHINE_dm600pvr += "${OPENDREAMBOX_V2_ONLY} ${OPENDREAMBOX_TUXBOX} ${MODEM_SUPPORT}"
OPENDREAMBOX_COMMON_MACHINE_R_dm600pvr += "${OPENDREAMBOX_TUXBOX_R} ${MODEM_SUPPORT_R} dreambox-blindscan-utils"
OPENDREAMBOX_COMMON_MACHINE_D_dm600pvr += "${OPENDREAMBOX_TUXBOX_D}"

OPENDREAMBOX_COMMON_MACHINE_dm500plus += "${OPENDREAMBOX_V2_ONLY} ${OPENDREAMBOX_TUXBOX} ${MODEM_SUPPORT}"
OPENDREAMBOX_COMMON_MACHINE_R_dm500plus += "${OPENDREAMBOX_TUXBOX_R} ${MODEM_SUPPORT_R} dreambox-blindscan-utils"
OPENDREAMBOX_COMMON_MACHINE_D_dm500plus += "${OPENDREAMBOX_TUXBOX_D}"

OPENDREAMBOX_COMMON_MACHINE_dm7020 += "${OPENDREAMBOX_V2_ONLY} ${OPENDREAMBOX_TUXBOX} ${MODEM_SUPPORT}"
OPENDREAMBOX_COMMON_MACHINE_R_dm7020 += "${OPENDREAMBOX_TUXBOX_R} ${MODEM_SUPPORT_R}"
OPENDREAMBOX_COMMON_MACHINE_D_dm7020 += "${OPENDREAMBOX_TUXBOX_D}"

OPENDREAMBOX_COMMON_MACHINE_dm7025 += "${OPENDREAMBOX_V3_ONLY} ${OPENDREAMBOX_EXPERIMENTAL} ${WLAN_SUPPORT}"
OPENDREAMBOX_COMMON_MACHINE_R_dm7025 += "${OPENDREAMBOX_EXPERIMENTAL_R} ${WLAN_SUPPORT_R}"
OPENDREAMBOX_COMMON_MACHINE_D_dm7025 += ""

OPENDREAMBOX_COMMON_MACHINE_dm800 += "${OPENDREAMBOX_V3_ONLY} ${OPENDREAMBOX_EXPERIMENTAL} ${WLAN_SUPPORT}"
OPENDREAMBOX_COMMON_MACHINE_R_dm800 += "${OPENDREAMBOX_EXPERIMENTAL_R} ${WLAN_SUPPORT_R} enigma2-plugin-systemplugins-videomode"
OPENDREAMBOX_COMMON_MACHINE_D_dm800 += ""

OPENDREAMBOX_COMMON_MACHINE_dm8000 += "${OPENDREAMBOX_V3_ONLY} ${OPENDREAMBOX_EXPERIMENTAL} ${WLAN_SUPPORT} ${WLAN_MADWIFI}"
OPENDREAMBOX_COMMON_MACHINE_R_dm8000 += "${OPENDREAMBOX_EXPERIMENTAL_R} \
	${WLAN_SUPPORT_R} ${WLAN_MADWIFI_R} ${DVDPLAYER_SUPPORT_R} \
	${DVDBURN_SUPPORT_R}  enigma2-plugin-systemplugins-videomode \
	${CDPLAYER_SUPPORT_R}"
OPENDREAMBOX_COMMON_MACHINE_D_dm8000 += ""

# collect the stuff into OPENDREAMBOX_COMMON
OPENDREAMBOX_COMMON += " ${OPENDREAMBOX_COMMON_MACHINE}"
OPENDREAMBOX_COMMON_R += " ${OPENDREAMBOX_COMMON_MACHINE_R}"
OPENDREAMBOX_COMMON_D += " ${OPENDREAMBOX_COMMON_MACHINE_D}"

# add bootstrap stuff
DEPENDS = "${OPENDREAMBOX_COMMON} ${OPENDREAMBOX_COMMON_D}"
IMAGE_INSTALL = "${OPENDREAMBOX_COMMON} ${OPENDREAMBOX_COMMON_R}"

# we don't want any locales, at least not in the common way.
IMAGE_LINGUAS = " "

inherit image

opendreambox_rootfs_postprocess() {
    curdir=$PWD
    cd ${IMAGE_ROOTFS}

    # generate /etc/image-version
    IMAGE_VERSION=`echo ${DISTRO_VERSION} | sed  's/\(.\)\.\(.\).\(.\)/\1\2\3/' `
    IMAGE_DATE="$(date +%Y%m%d%H%M)"
    IMAGE_TYPE="0"
    echo "version=${IMAGE_TYPE}${IMAGE_VERSION}${IMAGE_DATE}" > etc/image-version
    echo "comment=${DISTRO_NAME}" >> etc/image-version
    echo "target=9" >> etc/image-version
    echo "creator=OpenEmbedded <oe@dreamboxupdate.com>" >> etc/image-version
    echo "url=http://www.dreamboxupdate.com/" >> etc/image-version
    echo "catalog=http://www.dreamboxupdate.com/" >> etc/image-version

    # because we're so used to it
    ln -s opkg usr/bin/ipkg || true
    ln -s opkg-cl usr/bin/ipkg-cl || true

    cd $curdir
}

ROOTFS_POSTPROCESS_COMMAND += "opendreambox_rootfs_postprocess"

export NFO = '${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfo'

generate_nfo() {
    VER=`grep Version: "${IMAGE_ROOTFS}/usr/lib/ipkg/info/enigma2.control" | cut -b 10-12`
    echo "Enigma2: Experimental ${VER}" > ${NFO}
    echo "Machine: Dreambox ${MACHINE}" >> ${NFO}
    DATE=`date +%Y-%m-%d' '%H':'%M`
    echo "Date: ${DATE}" >> ${NFO}
    echo "Issuer: Dream Multimedia TV" >> ${NFO}
    echo "Link: ${DISTRO_FEED_URI}" >> ${NFO}
    if [ "${DESC}" != "" ]; then
        echo "Description: ${DESC}" >> ${NFO}
        echo "${DESC}" >> ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.desc
    fi
    MD5SUM=`md5sum ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfi | cut -b 1-32`
    echo "MD5: ${MD5SUM}" >> ${NFO}
}

do_rootfs_append_dm8000() {
    generate_nfo
}

