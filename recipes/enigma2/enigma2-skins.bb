DESCRIPTION = "Skins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PACKAGES_DYNAMIC = "enigma2-skin-*"

SRCDATE = "20100213"

# if you want the 2.7 release, use
#TAG = ";tag=enigma2-skins_rel27"
#PV = "2.7cvs${SRCDATE}"

# if you want experimental, use:
TAG = ""
PV = "experimental-cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-skins;module=enigma2-skins;method=pserver${TAG};date=${SRCDATE}"
FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "all"

inherit autotools

S = "${WORKDIR}/enigma2-skins"

python populate_packages_prepend () {
	enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)

	do_split_packages(d, enigma2_skindir, '(.*?)/.*', 'enigma2-skin-%s', 'Enigma2 Skin: %s', recursive=True, match_path=True, prepend=True)
}

python populate_packages_append () {
	enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)

	#clear rdepends by default
	for package in bb.data.getVar('PACKAGES', d, 1).split():
		bb.data.setVar('RDEPENDS_' + package, '', d)

	#todo add support for control files in skindir.. like plugins
}
