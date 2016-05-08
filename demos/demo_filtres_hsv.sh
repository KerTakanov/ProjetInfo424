function wait {
	read -p "Appuyez sur n'importe quelle touche pour continuer... " -n1 -s
	clear
}

echo "==================================================="
echo "============ DÃ©monstration Filtres HSV ============"
echo "==================================================="

echo "Application du filtre Teinte"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -hue 120

echo "Application du filtre Saturation"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -sat 1.5

echo "Application du filtre Luminosite"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -lum 85

echo "Application du filtre Mélange image par teinte"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -melhue ../assets/pbmlib.ppm
