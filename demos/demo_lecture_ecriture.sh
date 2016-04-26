function wait {
	read -p "Appuyez sur n'importe quelle touche pour continuer... " -n1 -s
	clear
}

rm ../assets/ouput.ppm
rm ../assets/ouput2.ppm

echo "===================================================="
echo "======= Démonstration Lecture/Ecriture image ======="
echo "===================================================="

echo "Ecriture d'une image sans appliquer de filtre vers assets/ouput.ppm :"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm

echo "Ecriture d'une image sans appliquer de filtre vers assets/ouput2.ppm :"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput2.ppm

echo "Ecriture d'une image en triplant le contraste vers assets/ouput.ppm :"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -ces 3

echo "Ecriture d'une image en diminuant de moitié le contraste vers assets/ouput.ppm :"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -ces 0.5
