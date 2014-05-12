define(['controller/selectionController', 'model/cacheModel', 'model/ordenReaprovicionamientoMasterModel', 'component/_CRUDComponent', 'controller/tabController', 'component/ordenReaprovicionamientoComponent',
 'component/proveedorComponent'
 ,
 'component/productoComponent'
 
 ],function(SelectionController, CacheModel, OrdenReaprovicionamientoMasterModel, CRUDComponent, TabController, OrdenReaprovicionamientoComponent,
 ProveedorComponent
 ,
 ProductoComponent
 ) {
    App.Component.OrdenReaprovicionamientoMasterComponent = App.Component.BasicComponent.extend({
        initialize: function() {
            var self = this;
            this.configuration = App.Utils.loadComponentConfiguration('ordenReaprovicionamientoMaster');
            var uComponent = new OrdenReaprovicionamientoComponent();
            uComponent.initialize();
            uComponent.render('main');
            Backbone.on(uComponent.componentId + '-post-ordenReaprovicionamiento-create', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-post-ordenReaprovicionamiento-edit', function(params) {
                self.renderChilds(params);
            });
            Backbone.on(uComponent.componentId + '-pre-ordenReaprovicionamiento-list', function() {
                self.hideChilds();
            });
            Backbone.on('ordenReaprovicionamiento-master-model-error', function(error) {
                Backbone.trigger(uComponent.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-master-save', view: self, error: error});
            });
            Backbone.on(uComponent.componentId + '-instead-ordenReaprovicionamiento-save', function(params) {
                self.model.set('ordenReaprovicionamientoEntity', params.model);
                if (params.model) {
                    self.model.set('id', params.model.id);
                } else {
                    self.model.unset('id');
                }
                var proveedorModels = self.proveedorComponent.componentController.proveedorModelList;
                self.model.set('listProveedor', []);
                self.model.set('createProveedor', []);
                self.model.set('updateProveedor', []);
                self.model.set('deleteProveedor', []);
                for (var i = 0; i < proveedorModels.models.length; i++) {
                    var m = proveedorModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createProveedor').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateProveedor').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < proveedorModels.deletedModels.length; i++) {
                    var m = proveedorModels.deletedModels[i];
                    self.model.get('deleteProveedor').push(m.toJSON());
                }
                var productoModels = self.productoComponent.componentController.productoModelList;
                self.model.set('listProducto', []);
                self.model.set('createProducto', []);
                self.model.set('updateProducto', []);
                self.model.set('deleteProducto', []);
                for (var i = 0; i < productoModels.models.length; i++) {
                    var m = productoModels.models[i];
                    var modelCopy = m.clone();
                    if (m.isCreated()) {
                        //set the id to null
                        modelCopy.unset('id');
                        self.model.get('createProducto').push(modelCopy.toJSON());
                    } else if (m.isUpdated()) {
                        self.model.get('updateProducto').push(modelCopy.toJSON());
                    }
                }
                for (var i = 0; i < productoModels.deletedModels.length; i++) {
                    var m = productoModels.deletedModels[i];
                    self.model.get('deleteProducto').push(m.toJSON());
                }
                self.model.save({}, {
                    success: function() {
                        uComponent.componentController.list();
                    },
                    error: function(error) {
                        Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-master-save', view: self, error: error});
                    }
                });
            });
        },
        renderChilds: function(params) {
            var self = this;
            this.tabModel = new App.Model.TabModel(
                    {
                        tabs: [
                            {label: "Proveedor", name: "proveedor", enable: true},
                            ,
                            {label: "Producto", name: "producto", enable: true},
                        ]
                    }
            );

            this.tabs = new TabController({model: this.tabModel});

            this.tabs.render('tabs');
            App.Model.OrdenReaprovicionamientoMasterModel.prototype.urlRoot = this.configuration.context;
            var options = {
                success: function() {
					self.proveedorComponent = new ProveedorComponent();
                    self.proveedorModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ProveedorModel), self.model.get('listProveedor'));
                    self.proveedorComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ProveedorModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ProveedorModel, App.Model.ProveedorList, self.proveedorModels)
                    });
                    self.proveedorComponent.render(self.tabs.getTabHtmlId('proveedor'));
                    Backbone.on(self.proveedorComponent.componentId + '-post-proveedor-create', function(params) {
                        params.view.currentProveedorModel.setCacheList(params.view.proveedorModelList);
                    });
					self.productoComponent = new ProductoComponent();
                    self.productoModels = App.Utils.convertToModel(App.Utils.createCacheModel(App.Model.ProductoModel), self.model.get('listProducto'));
                    self.productoComponent.initialize({
                        modelClass: App.Utils.createCacheModel(App.Model.ProductoModel),
                        listModelClass: App.Utils.createCacheList(App.Model.ProductoModel, App.Model.ProductoList, self.productoModels)
                    });
                    self.productoComponent.render(self.tabs.getTabHtmlId('producto'));
                    Backbone.on(self.productoComponent.componentId + '-post-producto-create', function(params) {
                        params.view.currentProductoModel.setCacheList(params.view.productoModelList);
                    });
                    self.proveedorToolbarModel = self.proveedorComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.proveedorComponent.setToolbarModel(self.proveedorToolbarModel);
                    self.productoToolbarModel = self.productoComponent.toolbarModel.set(App.Utils.Constans.containmentToolbarConfiguration);
                    self.productoComponent.setToolbarModel(self.productoToolbarModel);
                	
                     
                
                    Backbone.on(self.proveedorComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController();
                        App.Utils.getComponentList('proveedorComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no proveedors to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Proveedor List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('post-selection', function(models) {
                        var cacheProveedorModel = App.Utils.createCacheModel(App.Model.ProveedorModel);
                        models = App.Utils.convertToModel(cacheProveedorModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.proveedorComponent.componentController.proveedorModelList);
                        	model.save('',{});
                        }
                        self.proveedorComponent.componentController.showEdit=false;
                        self.proveedorComponent.componentController.list();
                        
                    });
                    Backbone.on(self.productoComponent.componentId + '-toolbar-add', function() {
                        var selection = new App.Controller.SelectionController();
                        App.Utils.getComponentList('productoComponent', function(componentName, model) {
                            if (model.models.length == 0) {
                                alert('There is no productos to select.');
                            } else {
                                selection.showSelectionList({list: model, name: 'name', title: 'Producto List'});
                            }
                            ;
                        });
                    });
                    Backbone.on('post-selection', function(models) {
                        var cacheProductoModel = App.Utils.createCacheModel(App.Model.ProductoModel);
                        models = App.Utils.convertToModel(cacheProductoModel, models);
                        for (var i = 0; i < models.length; i++) {
                        	var model = models[i];
                        	model.setCacheList(self.productoComponent.componentController.productoModelList);
                        	model.save('',{});
                        }
                        self.productoComponent.componentController.showEdit=false;
                        self.productoComponent.componentController.list();
                        
                    });
                    $('#tabs').show();
                },
                error: function() {
                    Backbone.trigger(self.componentId + '-' + 'error', {event: 'ordenReaprovicionamiento-edit', view: self, id: id, data: data, error: error});
                }
            };
            if (params.id) {
                self.model = new App.Model.OrdenReaprovicionamientoMasterModel({id: params.id});
                self.model.fetch(options);
            } else {
                self.model = new App.Model.OrdenReaprovicionamientoMasterModel();
                options.success();
            }


        },
        hideChilds: function() {
            $('#tabs').hide();
        }
    });

    return App.Component.OrdenReaprovicionamientoMasterComponent;
});