DESCRIPTION = "Enigma2 is an experimental, but useful framebuffer-based frontend for DVB functions"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
DEPENDS = "jpeg libungif libmad libpng libsigc++-1.2 gettext-native \
	dreambox-dvbincludes freetype libdvbsi++ python swig-native \
	libfribidi libxmlccwrap libdreamdvd gstreamer gst-plugin-dvbmediasink \
	gst-plugins-bad gst-plugins-good gst-plugins-ugly"
RDEPENDS = "python-codecs python-core python-lang python-re python-threading \
	python-xml python-fcntl gst-plugin-decodebin gst-plugin-decodebin2 python-stringold \
	gst-plugin-queue2 gst-plugin-app \
	gst-plugin-id3demux gst-plugin-mad gst-plugin-ogg gst-plugin-playbin \
	gst-plugin-typefindfunctions gst-plugin-ivorbis gst-plugin-audioconvert gst-plugin-audioresample \
	gst-plugin-wavparse python-netclient gst-plugin-mpegstream gst-plugin-selector \
	gst-plugin-flac gst-plugin-dvbmediasink gst-plugin-mpegdemux \
	gst-plugin-neonhttpsrc gst-plugin-mpegaudioparse gst-plugin-subparse \
	gst-plugin-apetag gst-plugin-icydemux gst-plugin-autodetect \
	glibc-gconv-iso8859-15"

RDEPENDS_append_dm7020 = " gst-plugin-ossaudio"
RDEPENDS_append_dm7025 = " gst-plugin-alsa alsa-conf"
RDEPENDS_append_dm8000 = " gst-plugin-alsa alsa-conf gst-plugin-avi gst-plugin-matroska \
	gst-plugin-qtdemux gst-plugin-cdxaparse gst-plugin-cdio gst-plugin-vcdsrc"
RDEPENDS_append_dm800 = " gst-plugin-alsa alsa-conf gst-plugin-matroska gst-plugin-qtdemux"
RDEPENDS_append_dm500hd = " gst-plugin-alsa alsa-conf gst-plugin-avi gst-plugin-matroska \
	gst-plugin-qtdemux gst-plugin-cdxaparse gst-plugin-cdio gst-plugin-vcdsrc"

# 'forward depends' - no two providers can have the same PACKAGES_DYNAMIC, however both
# enigma2 and enigma2-plugins produce enigma2-plugin-*.
#DEPENDS += "enigma2-plugins"
#PACKAGES_DYNAMIC = "enigma2-plugin-*"

DESCRIPTION_append_enigma2-plugin-extensions-cutlisteditor = "enables you to cut your movies."
RDEPENDS_enigma2-plugin-extensions-cutlisteditor = "aio-grab"
DESCRIPTION_append_enigma2-plugin-extensions-graphmultiepg = "shows a graphical timeline EPG."
DESCRIPTION_append_enigma2-plugin-extensions-pictureplayer = "displays photos on the TV."
DESCRIPTION_append_enigma2-plugin-systemplugins-frontprocessorupdate = "keeps your frontprocessor up to date."
DESCRIPTION_append_enigma2-plugin-systemplugins-positionersetup = "helps you installing a motorized dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-satelliteequipmentcontrol = "allows you to fine-tune DiSEqC-settings."
DESCRIPTION_append_enigma2-plugin-systemplugins-satfinder = "helps you to align your dish."
DESCRIPTION_append_enigma2-plugin-systemplugins-skinselector = "shows a menu with selectable skins."
DESCRIPTION_append_enigma2-plugin-systemplugins-videomode = "selects advanced video modes"
RDEPENDS_enigma2-plugin-extensions-dvdplayer = "libdreamdvd0"
RDEPENDS_enigma2-plugin-systemplugins-nfiflash = "twisted-web"
RDEPENDS_enigma2-plugin-systemplugins-softwaremanager = "twisted-web"
RCONFLICTS_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
RREPLACES_enigma2-plugin-systemplugins-softwaremanager = "enigma2-plugin-systemplugins-configurationbackup enigma2-plugin-systemplugins-softwareupdate"
DESCRIPTION_append_enigma2-plugin-systemplugins-crashlogautosubmit = "automatically send crashlogs to Dream Multimedia"
RDEPENDS_enigma2-plugin-systemplugins-crashlogautosubmit = "twisted-mail twisted-names python-compression python-mime python-email"
DESCRIPTION_append_enigma2-plugin-systemplugins-cleanupwizard = "informs you on low internal memory on system startup."
DESCRIPTION_append_enigma2-plugin-extenstions-modem = "opens a menu to connect to internet via builtin modem."
RDEPENDS_enigma2-plugin-extensions-modem = "dreambox-modem-ppp-scripts"
DESCRIPTION_append_enigma2-plugin-systemplugins-wirelesslan = "helps you configuring your wireless lan"
RDEPENDS_enigma2-plugin-systemplugins-wirelesslan = "wpa-supplicant wireless-tools"
DESCRIPTION_append_enigma2-plugin-systemplugins-networkwizard = "provides easy step by step network configuration"

PN = "enigma2"
PR = "r0"

SRCDATE = "20100212"
#SRCDATE is NOT used by git to checkout a specific revision
#but we need it to build a ipk package version
#when you like to checkout a specific revision of e2 you need
#have to specify a commit id or a tag name in SRCREV

# if you want upcoming release, use:
####################################################
BRANCH = "master"
PV = "2.8git${SRCDATE}"
SRCREV = "a37ddbb7785de5f1d944f4937a5b2914ce6a3862"
####################################################

# if you want experimental use
####################################################
#BRANCH = "experimental"
#PV = "experimental-git${SRCDATE}"
#SRCREV = ""
####################################################

# if you want a 2.7-based release, use
####################################################
#BRANCH="2.7"
#PV = "2.7git${SRCDATE}"
# if you want 2.7.0 use
#SRCREV = "d5a16c6e9d0ee1cc2dc0d65b4321842dea4b0891"
####################################################

SRC_URI = "git://git.opendreambox.org/git/enigma2.git;protocol=git;branch=${BRANCH};tag=${SRCREV} \
	file://new-hotplug.patch;patch=1;pnum=1 \
	file://fix-dvdburn-pathes.patch;patch=1;pnum=1 \
	file://enigma2.sh"

S = "${WORKDIR}/git"

FILES_${PN} += "${datadir}/fonts"
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--enable-maintainer-mode --with-target=native --with-libsdl=no"

do_install_append() {
	install -m 0755 ${WORKDIR}/enigma2.sh ${D}/usr/bin/
}

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', '%s ', recursive=True, match_path=True, prepend=True)
}

do_stage() {
	install -d ${STAGING_INCDIR}/enigma2
	install -m 0644 ${S}/include/*.h ${STAGING_INCDIR}/enigma2
	for dir in actions base components driver dvb dvb/lowlevel dvb_ci gdi gui mmi nav python service; do
		install -d ${STAGING_INCDIR}/enigma2/lib/$dir;
		install -m 0644 ${S}/lib/$dir/*.h ${STAGING_INCDIR}/enigma2/lib/$dir;
	done
}
