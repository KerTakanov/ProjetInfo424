function wait {
	read -p "Appuyez sur n'importe quelle touche pour continuer... " -n1 -s
	clear
}

echo "===================================================="
echo "======= Démonstration Matrice de Convolution ======="
echo "===================================================="

echo "Application du filtre Moyenne"
wait
./bl_demo.sh ../assets/input.ppm -o ../assets/ouput.ppm -moy

echo "Application du filtre Laplacien"
wait
./bl_demo.sh ../assets/input.ppm -o ../assets/ouput.ppm -lp

echo "Application du filtre Passe-Haut"
wait
./bl_demo.sh ../assets/input.ppm -o ../assets/ouput.ppm -ph