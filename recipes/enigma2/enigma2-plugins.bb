DESCRIPTION = "Additional plugins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PACKAGES_DYNAMIC = "enigma2-plugin-*"

SRCDATE = "20100104"

# if you want the 2.7.0 release, use
TAG = ";tag=enigma2-plugins_rel27"
PV = "2.7cvs${SRCDATE}"

# if you want experimental, use:
#TAG = ""
#PV = "experimental-cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-plugins;module=enigma2-plugins;method=pserver${TAG};date=${SRCDATE}"

FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit autotools

S = "${WORKDIR}/enigma2-plugins"

DEPENDS = "python-pyopenssl python-gdata streamripper"
DEPENDS += "enigma2"

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)

	def getControlLines(mydir, d, package):
		import os
		try:
			#ac3lipsync is renamed since 20091121 to audiosync.. but rename in cvs is not possible without lost of revision history..
			#so the foldername is still ac3lipsync
			if package == 'audiosync':
				package = 'ac3lipsync'
			src = open(mydir + package + "/CONTROL/control").read()
		except IOError:
			return
		for line in src.split("\n"):
			if line.startswith('Package: '):
				full_package = line[9:]
			if line.startswith('Depends: '):
				bb.data.setVar('RDEPENDS_' + full_package, ' '.join(line[9:].split(', ')), d)
			if line.startswith('Description: '):
				bb.data.setVar('DESCRIPTION_' + full_package, line[13:], d)
			if line.startswith('Replaces: '):
				bb.data.setVar('RREPLACES_' + full_package, ' '.join(line[10:].split(', ')), d)
			if line.startswith('Conflicts: '):
				bb.data.setVar('RCONFLICTS_' + full_package, ' '.join(line[11:].split(', ')), d)
			if line.startswith('Maintainer: '):
				bb.data.setVar('MAINTAINER_' + full_package, line[12:], d)


	mydir = bb.data.getVar('D', d, 1) + "/../enigma2-plugins/"
	for package in bb.data.getVar('PACKAGES', d, 1).split():
		getControlLines(mydir, d, package.split('-')[-1])
}
