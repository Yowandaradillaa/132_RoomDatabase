package com.example.myroom.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myroom.view.DetailSiswaScreen
import com.example.myroom.view.EditSiswaScreen
import com.example.myroom.view.EntrySiswaScreen
import com.example.myroom.view.HomeScreen
import com.example.myroom.view.route.DestinasiDetailSiswa
import com.example.myroom.view.route.DestinasiEditSiswa
import com.example.myroom.view.route.DestinasiEntry
import com.example.myroom.view.route.DestinasiHome
import com.example.myroom.view.route.DestinasiDetailSiswa.itemIdArg

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(
        navController = navController,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { idSiswa ->
                    navController.navigate("${DestinasiDetailSiswa.route}/$idSiswa")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(itemIdArg) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val idSiswa = backStackEntry.arguments?.getInt(itemIdArg) ?: return@composable
            DetailSiswaScreen(
                navigateBack = { navController.navigateUp() },
                navigateToEditItem = { editId ->
                    navController.navigate("${DestinasiEditSiswa.route}/$editId")
                }
            )
        }

        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val idSiswa = backStackEntry.arguments?.getInt(DestinasiEditSiswa.itemIdArg) ?: return@composable
            EditSiswaScreen(
                idSiswa = idSiswa,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
